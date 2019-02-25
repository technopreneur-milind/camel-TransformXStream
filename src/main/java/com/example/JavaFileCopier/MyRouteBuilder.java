package com.example.JavaFileCopier;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:F:/data/transformXStream/input/?noop=true").process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				exchange.getIn().setBody(new Employee(1, "test", "Hyd"));
			}
		}).marshal().xstream()
		.to("file:F:/data/transformXStream/output?fileName=out.xml");
	}
}
