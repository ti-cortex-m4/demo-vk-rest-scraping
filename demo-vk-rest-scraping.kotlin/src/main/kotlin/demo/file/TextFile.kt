package demo.file

import com.google.common.base.Charsets
import com.google.common.base.Joiner
import com.google.common.base.Splitter
import com.google.common.collect.Lists
import com.google.common.io.Files
import java.io.File

class TextFile(fileName: String) {

    private val CHARSET = Charsets.UTF_8
    private val fileName: String

    init {
        this.fileName = "src/main/resources/" + fileName
    }

    fun load(): String {
        val file = File(fileName)
        val source = Files.asCharSource(file, CHARSET)
        return source.read()
    }

    fun loadAsIterable(): Iterable<String> {
        return Splitter.on('\n').trimResults().omitEmptyStrings().split(load())
    }

    fun loadAsList(): List<String> {
        return Lists.newArrayList(loadAsIterable())
    }

    fun save(value: String) {
        val file = File(fileName)
        val sink = Files.asCharSink(file, CHARSET)
        sink.write(value)
    }

    fun save(values: List<String>) {
        save(Joiner.on('\n').join(values))
    }
}