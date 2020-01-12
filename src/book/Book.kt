package book

const val MAX_NUMBER_BOOKS = 20

class Book(val author: String, val title: String, val year: Int) {

    companion object Constants {
        const val BASE_URL = "http://www.turtlecare.net/"
    }

    fun getTitleAndAuthor(): Pair<String, String> {
        return title to author
    }

    fun getTitleAuthorAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(hasBooks: Int): Boolean {
        return hasBooks < MAX_NUMBER_BOOKS
    }

    fun printUrl() {
        println("$BASE_URL$title.html")
    }
}

fun main(args: Array<String>) {
    val book = Book("Л.Н. Толстой", "Война и мир", 1870)

    val bookTitleAuthor = book.getTitleAndAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorAndYear()
    println("Книга ${bookTitleAuthor.first} была написана ${bookTitleAuthor.second}")
    println("Книга ${bookTitleAuthorYear.first} была написана ${bookTitleAuthorYear.second} в ${bookTitleAuthorYear.third} году")

    val allBooks = setOf(
            "The Two Gentlemen of Verona",
            "Henry V",
            "Macbeth"
    )
    val library = mapOf("William Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })
    println(library.any { it.value.contains("Macbeth") })

    val moreBooks = mutableMapOf("The Pickwick Papers" to "Charles Dickens")
    println(moreBooks.getOrPut("Jane Eyre", { "Charlotte Brontë" }))
}