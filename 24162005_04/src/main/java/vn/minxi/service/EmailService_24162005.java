package vn.minxi.service;

import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailService_24162005 {

	private static final String FROM_EMAIL = "huynhanh141026@gmail.com";
	// Cập nhật App Password mới (đã gộp liền chuỗi)
	private static final String APP_PASSWORD = "icglvjfdexjedojj"; 

	public static boolean sendOTP(String toEmail, String otpCode) {
		if (toEmail == null || toEmail.trim().isEmpty()) {
			System.err.println("[EMAIL ERROR] Địa chỉ email nhận bị trống!");
			return false;
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM_EMAIL, APP_PASSWORD);
			}
		};

		try {
			Session session = Session.getInstance(props, auth);
			session.setDebug(true);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM_EMAIL, "Ứng Dụng Video"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail.trim()));
			message.setSubject("Mã xác thực OTP đăng ký tài khoản", "UTF-8");

			String htmlContent = "<div style='font-family: Arial, sans-serif; padding: 20px; border: 1px solid #ddd;'>"
					+ "<h2>Xác thực đăng ký tài khoản</h2>"
					+ "<p>Mã OTP của bạn là: <b style='color: red; font-size: 24px;'>" + otpCode + "</b></p>"
					+ "<p>Mã này có hiệu lực trong phiên đăng ký hiện tại.</p>" + "</div>";

			message.setContent(htmlContent, "text/html; charset=UTF-8");

			Transport.send(message);
			System.out.println("[EMAIL SUCCESS] Đã gửi OTP thành công tới: " + toEmail);
			return true;
		} catch (Exception e) {
			System.err.println("[EMAIL ERROR] Lỗi chi tiết khi gửi Mail:");
			e.printStackTrace();
			return false;
		}
	}
}