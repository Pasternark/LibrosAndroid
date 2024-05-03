import com.example.librosandroid.R
import com.example.librosandroid.model.Books

/**
 * Crea una data class con 10 elementos en una lista Books,
 * a la cual le corresponden tres strings (nombre, autor y año del libro)
 * y una imagen
 */
class Datasource(){
    fun loadBooks(): List<Books>{
        return listOf<Books>(
            Books(R.string.books1, R.string.autor1, R.string.year1, R.drawable.disenandoappsparamoviles),
            Books(R.string.books2, R.string.autor2, R.string.year2, R.drawable.mobileapplicationdevelpmentusabilityandsecurity),
            Books(R.string.books3, R.string.autor3, R.string.year3, R.drawable.howtobuildappswithkotlin),
            Books(R.string.books4, R.string.autor4, R.string.year4, R.drawable.desarrollodeaplicacionesmovilesconkotlin),
            Books(R.string.books5, R.string.autor5, R.string.year5, R.drawable.desarrollodeaplicacionesparaandroid),
            Books(R.string.books6, R.string.autor6, R.string.year6, R.drawable.androidprograming),
            Books(R.string.books7, R.string.autor7, R.string.year7, R.drawable.creaunaappparamovil),
            Books(R.string.books8, R.string.autor8, R.string.year8, R.drawable.iniciacionaandroidenkotlincasospracticos),
            Books(R.string.books9, R.string.autor9, R.string.year9, R.drawable.cursodeprogramaci_nandroidconkotlin),
            Books(R.string.books10, R.string.autor10, R.string.year10, R.drawable.androidstudiogiraffeessentials)

        )
    }
}
