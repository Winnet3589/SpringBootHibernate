package com.springboot.hibernate.controllers.others;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SFTPFileTransferController {

  private static final String REMOTE_HOST = "localhost";
  private static final String USERNAME = "foo";
  private static final String PASSWORD = "pass";
  private static final int REMOTE_PORT = 2222;
  private static final int SESSION_TIMEOUT = 10000;
  private static final int CHANNEL_TIMEOUT = 5000;

  @GetMapping(value = "/sftp/readFile")
  public void readFile() {

    //ssh-keyscan -H -t rsa localhost >> known_hosts
    Session jschSession = null;

    try {

      JSch jsch = new JSch();
      jsch.setKnownHosts("/Users/bkitsolution/.ssh/known_hosts");
      jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);

      // authenticate using private key
      // jsch.addIdentity("/home/mkyong/.ssh/id_rsa");
      // jsch.addIdentity("/Users/Project/sftp/sftp_key");

      // authenticate using password
      jschSession.setPassword(PASSWORD);

      // 10 seconds session timeout
      jschSession.connect(SESSION_TIMEOUT);

      Channel sftp = jschSession.openChannel("sftp");

      // 5 seconds timeout
      sftp.connect(CHANNEL_TIMEOUT);

      ChannelSftp channelSftp = (ChannelSftp) sftp;

      // transfer file from local to remote server
      String remoteFile = "/upload/banner.txt";
      String localFile = "/Users/Project/ws_traning/SpringBootHibernate/src/main/resources/banner.txt";
      channelSftp.put(localFile, remoteFile);

      // download file from remote server to local
       remoteFile = "/upload/bannerNoexist.txt";
       localFile = "/Users/Project/ws_traning/SpringBootHibernate/src/main/resources/bannerNoexist.txt";
       channelSftp.get(remoteFile, localFile);

      channelSftp.exit();

    } catch (JSchException | SftpException e) {

      e.printStackTrace();

    } finally {
      if (jschSession != null) {
        jschSession.disconnect();
      }
    }

    System.out.println("Done");
  }
}
