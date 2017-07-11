package br.com.xyinc.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import br.com.xyinc.commons.config.XYCommonsConfig;
import br.com.xyinc.repository.config.RepositoryConfig;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(value = {RepositoryConfig.class, XYCommonsConfig.class})
@ComponentScan("br.com.xyinc.business")
public class XYBusinessConfig {

}