package br.com.estudos.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Value("\${info.build.version}")
    private val buildVersion: String? = null

    companion object {
        private const val apiName = "Api Caixa Eletronico"
        private const val apiDescription = "operacoes e concultas disponiveis para o caixa eletronico"
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title(apiName).description(apiDescription).version(buildVersion).build()
    }


}