import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, 8081) {
        routing {
            get("/validar") {
                val uf = call.request.queryParameters["uf"]
                val inscricao = call.request.queryParameters["inscricao"]

                if(uf == null){
                    call.respondText("{\"valido\": false, \"mensagem\": \"UF obrigatória\"}", ContentType.Application.Json)
                    return@get
                }

                if(inscricao == null){
                    call.respondText("{\"valido\": false, \"mensagem\": \"Inscriçao estadual obrigatória\"}", ContentType.Application.Json)
                    return@get
                }

                call.respondText("{\"valido\":${inscricao.validar(uf)}}", ContentType.Application.Json)
            }
        }
    }.start(wait = true)
}