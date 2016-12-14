package com.oblenergo.service;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.model.Orders;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

  private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

  @Autowired
  SapServiceImpl sapServiceImpl;

  @Autowired
  ItextServiceImpl itextServiceImpl;

  @Autowired
  ApplicationContext appContext;

  @Autowired
  private MimeMessage mimeMessage;

  @Autowired
  private Environment environment;

  @Autowired
  private JavaMailSenderImpl senderImpl;

  @Override
  public void sendMail(OrderDTO orderDTO, Orders order, String email, String text) {

    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
      messageHelper.setFrom(environment.getRequiredProperty("mail.sender.address"));
      messageHelper.setTo(email);
      messageHelper.setText(text);
      messageHelper.addAttachment("rahunok.pdf",
          new ByteArrayResource(sapServiceImpl.getBillPDF(orderDTO.getOrderNum())));
      messageHelper.addAttachment("permit.pdf", new ByteArrayResource(itextServiceImpl.writePermit(order)));
      senderImpl.send(mimeMessage);
    } catch (MailException e) {
      LOGGER.error("Failure when sending the message", e);
    } catch (MessagingException e1) {
      LOGGER.error("There was a problem setting the sender address", e1);
    }
  }

  @Override
  public void sendMailOnlyPermit(Orders orders, String email, String text) {

    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
      messageHelper.setFrom(environment.getRequiredProperty("mail.sender.address"));
      messageHelper.setTo(email);
      messageHelper.setText(text);
      messageHelper.addAttachment("permit.pdf", new ByteArrayResource(itextServiceImpl.writePermit(orders)));
      senderImpl.send(mimeMessage);
    } catch (MailException e) {
      LOGGER.error("Failure when sending the message", e);
    } catch (MessagingException e1) {
      LOGGER.error("There was a problem setting the sender address", e1);
    }
  }

  @Override
  public void sendMailWithoutPDF(String email, String text) {

    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
      messageHelper.setFrom(environment.getRequiredProperty("mail.sender.address"));
      messageHelper.setTo(email);
      messageHelper.setText(text);
      senderImpl.send(mimeMessage);
    } catch (MailException e) {
      LOGGER.error("Failure when sending the message", e);
    } catch (MessagingException e1) {
      LOGGER.error("There was a problem setting the sender address", e1);
    }
  }

}
