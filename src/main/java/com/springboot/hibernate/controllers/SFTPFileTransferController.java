package com.springboot.hibernate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jcraft.jsch.*;

@RestController
@RequiredArgsConstructor
public class SFTPFileTransferController {

  private static final String REMOTE_HOST = "localhost";
  private static final String USERNAME = "foo";
  private static final String PASSWORD = "pass";
  private static final int REMOTE_PORT = 22;
  private static final int SESSION_TIMEOUT = 10000;
  private static final int CHANNEL_TIMEOUT = 5000;

  @GetMapping(value = "/sftp/readFile")
  public void readFile() {

    //ssh-keyscan -H -t rsa localhost >> known_hosts
    String remoteFile = "/upload/banner2.txt";
    String localFile = "/Users/Project/ws_traning/SpringBootHibernate/src/main/resources/banner.txt";

    Session jschSession = null;

    try {

      JSch jsch = new JSch();
      jsch.setKnownHosts("/Users/bkitsolution/.ssh/known_hosts");
      jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);

      // authenticate using private key
      // jsch.addIdentity("/home/mkyong/.ssh/id_rsa");
//       jsch.addIdentity("/Users/Project/sftp/sftp_key");

      // authenticate using password
      jschSession.setPassword(PASSWORD);

      // 10 seconds session timeout
      jschSession.connect(SESSION_TIMEOUT);

      Channel sftp = jschSession.openChannel("sftp");

      // 5 seconds timeout
      sftp.connect(CHANNEL_TIMEOUT);

      ChannelSftp channelSftp = (ChannelSftp) sftp;

      // transfer file from local to remote server
      channelSftp.put(localFile, remoteFile);

      // download file from remote server to local
      // channelSftp.get(remoteFile, localFile);

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
