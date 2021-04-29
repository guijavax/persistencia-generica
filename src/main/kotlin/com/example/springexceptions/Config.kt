package com.example.springexceptions

import com.example.springexceptions.generic.RepositoryGeneric
import com.example.springexceptions.services.ClienteService
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [ClienteService::class, RepositoryGeneric::class])
class Config {}