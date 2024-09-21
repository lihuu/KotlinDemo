package com.demo.text

import java.io.File
import java.util.stream.Collectors

/**
 *
 * @author lihu <1449488533qq@gmail.com>
 * @since 2024/9/19
 */
class TextProcessor {
    fun processText(text: String): List<WordFrequency> {
        val words = text.replace(Regex("[^a-zA-Z]"), " ")
            .split(" ")
            .filter { it.isNotEmpty() }
        return words
            .stream().collect(Collectors.groupingBy({ it }, Collectors.counting()))
            .map { WordFrequency(it.key, it.value.toInt()) }
            .sortedBy { it.frequency }
    }
}

fun TextProcessor.processFile(file: File): List<WordFrequency> {
    val content = file.readText(Charsets.UTF_8)
    return processText(content)
}

data class WordFrequency(val word: String, val frequency: Int) {
    override fun toString(): String {
        return "WordFrequency(word='$word', frequency=$frequency)"
    }
}




