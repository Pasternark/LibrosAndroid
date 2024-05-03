package com.example.librosandroid

import Datasource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.librosandroid.model.Books
import com.example.librosandroid.ui.theme.LibrosAndroidTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibrosAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Manda llamar a la función principal: BooksApp
                    BooksApp()
                }
            }
        }
    }
}

/**
 * Función principal de la clase
 */
@Composable
fun BooksApp() {
    BooksList(
        booksList = Datasource().loadBooks()
    )
}

/**
 * Función BooksCard donde damos forma a como se mostrará la Card de Books
 * Esta contiene un elemento image y tres elementos text
 */
@Composable
fun BooksCard(books: Books, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image( //Carga la imagen del libro a la Card
                painter = painterResource(books.imageResourceId),
                contentDescription = stringResource(books.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),
                contentScale = ContentScale.Crop
            )
            Text( //Carga el string correspondiente al nombre del libro a la Card
                text = LocalContext.current.getString(books.stringResourceId),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .padding(bottom = 4.dp),
                style = MaterialTheme.typography.headlineSmall

            )
            Text( //Carga el string correspondiente al autor del libro a la Card
                text = LocalContext.current.getString(books.stringAutorId),
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 20.sp
            )
            Text( //Carga el string correspondiente al año del libro a la Card
                text = LocalContext.current.getString(books.stringYearId),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun BooksList(booksList: List<Books>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(booksList) { books ->
            BooksCard(
                books = books,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BooksCardPreview() {
    LibrosAndroidTheme {
        BooksCard(
            Books(
                R.string.books1,
                R.string.autor1,
                R.string.year1,
                R.drawable.disenandoappsparamoviles
            )
        )
    }
}