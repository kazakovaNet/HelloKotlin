import java.util.*

open class Book(val title: String, val author: String, var pages: Int = 0) {

    private var currentPage = 1

    open fun readPage() {
        currentPage++
    }
}

class EBook(title: String, author: String, val format: String = "text") : Book(title, author) {

    var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}

fun Book.getWeight(): Double {
    return pages * 1.5
}

fun Book.tornPages(torn: Int) {
    if (pages >= torn) {
        this.pages -= torn
    } else {
        pages = 0
    }
}

class Puppy {
    fun playWithBook(book: Book) {
        val tornPage = Random().nextInt(book.pages + 1)
        book.tornPages(tornPage)
        println("Puppy tore out the page count $tornPage")
    }
}

fun main() {
    val book = Book(title = "Book Title", author = "Book Author", pages = 5)
    val puppy = Puppy()

    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} pages left in book")
    }
}