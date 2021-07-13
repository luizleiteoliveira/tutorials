package com.luizleiteoliveira.tutorials

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.fasterxml.jackson.databind.ObjectMapper
import org.kxtra.slf4j.getLogger
import java.io.InputStream
import java.io.OutputStream

class ApiGatewayHandler: RequestStreamHandler {

    companion object {
        private val LOGGER = getLogger()
        private val mapper = ObjectMapper()
    }

    override fun handleRequest(inputStream: InputStream?, outputStream: OutputStream?, context: Context?) {
        TODO("Not yet implemented")
    }
}