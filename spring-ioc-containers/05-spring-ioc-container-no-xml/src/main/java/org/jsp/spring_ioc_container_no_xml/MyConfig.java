package org.jsp.spring_ioc_container_no_xml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.jsp.spring_ioc_container_no_xml")
@ComponentScan(basePackages = {"org.jsp.spring_ioc_container_no_xml.inser_into_database", "org.jsp.spring_ioc_container_no_xml"})
public class MyConfig {

}