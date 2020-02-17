import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        routing {
            get("/validar") {
                val uf = call.request.queryParameters["uf"]
                val inscricao = call.request.queryParameters["inscricao"]
                val siglas = arrayListOf("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO")

                when {
                    uf == null -> {
                        call.respondText("{\"valido\": false, \"mensagem\": \"UF obrigatória\"}", ContentType.Application.Json)
                        return@get
                    }
                    uf.length != 2 -> {
                        call.respondText("{\"valido\": false, \"mensagem\": \"UF inválida\"}", ContentType.Application.Json)
                        return@get
                    }
                    inscricao == null -> {
                        call.respondText("{\"valido\": false, \"mensagem\": \"Inscriçao estadual obrigatória\"}", ContentType.Application.Json)
                        return@get
                    }
                    !siglas.contains(uf) -> {
                        call.respondText("{\"valido\": false, \"mensagem\": \"UF incorreta\"}", ContentType.Application.Json)
                        return@get
                    }
                    else -> {
                        if(inscricao.validar(uf)) {
                            call.respondText("{\"valido\": true}", ContentType.Application.Json)
                        } else {
                            call.respondText("{\"valido\": false, \"mensagem\": \"Inscrição estadual inválida\"}", ContentType.Application.Json)
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}