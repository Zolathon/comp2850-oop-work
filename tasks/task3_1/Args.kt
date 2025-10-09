import kotlin.system.exitProcess

fun main(argv: Array<String>) {
    if (argv.size == 2) {
        println(argv[0])
        println(argv[1])
    }
    else {
        exitProcess(1)
    }

}