package com.dais39.springboot21kt

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

/*
    @ConfigurationPropertiesを利用する場合、
    @Componentを設定クラスに付与するか、
    @EnableConfigurationProperties(設定クラス)をJavaConfigに付与する必要がある
 */

@SpringBootApplication
//@EnableConfigurationProperties(SampleConfig::class)
class SpringBoot21KtApplication

fun main(args: Array<String>) {
    runApplication<SpringBoot21KtApplication>(*args)
}

@Component
@ConfigurationProperties(prefix = "sample")
class SampleConfig {

    lateinit var foo: String

    lateinit var bar: String
}

@Component
class SampleLauncher(private val config: SampleConfig) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println(config.foo)
        println(config.bar)
    }
}
