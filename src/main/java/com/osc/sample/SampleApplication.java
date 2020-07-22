package com.osc.sample;

import org.apache.derby.drda.NetworkServerControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.PrintWriter;
import java.net.InetAddress;

/**
 * <pre>
 * Sample SpringBoot Application
 *
 * Application 구동 시 DB 초기화가 필요한 경우 다음 두 가지 중 하나를 선택하여 옵션으로 입력한다.
 * <ul>
 *     <li>-Dspring.jpa.hibernate.ddl-auto=create</li>
 *     <li>-Dspring.datasource.initialization-mode=always</li>
 * </ul>
 * </pre>
 */
@SpringBootApplication
public class SampleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		// Start Derby DB as network server mode
		NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("0.0.0.0"), 1527);
		server.start(new PrintWriter(System.out));

		SpringApplication.run(SampleApplication.class, args);
	}

	/**
	 * <pre>
	 * Configure spring application builder.
	 * </pre>
	 *
	 * @param builder the builder
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SampleApplication.class)
				/*.bannerMode(org.springframework.boot.Banner.Mode.CONSOLE)*/;
	}
}
