package com.luizleiteoliveira.tutorials

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import org.kxtra.slf4j.getLogger


class ApiGatewayHandler: RequestStreamHandler {

    companion object {
        private val LOGGER = getLogger()
    }

    override fun handleRequest(inputStream: InputStream?, outputStream: OutputStream?, context: Context?) {
        val newLine = System.getProperty("line.separator")
        val result = StringBuilder()
        BufferedReader(InputStreamReader(inputStream)).use { reader ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                result
                    .append(line)
                    .append(newLine)
            }
        }
        LOGGER.info(result.toString())

    }
}