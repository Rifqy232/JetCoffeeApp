package com.mry.jetcoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mry.jetcoffeeapp.model.Menu
import com.mry.jetcoffeeapp.model.dummyBestSellerMenu
import com.mry.jetcoffeeapp.model.dummyCategory
import com.mry.jetcoffeeapp.model.dummyMenu
import com.mry.jetcoffeeapp.ui.components.CategoryItem
import com.mry.jetcoffeeapp.ui.components.MenuItem
import com.mry.jetcoffeeapp.ui.components.SearchBar
import com.mry.jetcoffeeapp.ui.components.SectionText
import com.mry.jetcoffeeapp.ui.theme.JetCoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeAppTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Banner()
        SectionText(
            title = stringResource(id = R.string.section_category),
        )
        CategoryRow()
        SectionText(title = stringResource(id = R.string.section_favorite_menu))
        MenuRow(listMenu = dummyMenu)
        SectionText(title = stringResource(id = R.string.section_best_seller_menu))
        MenuRow(listMenu = dummyBestSellerMenu)
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(dummyCategory, key = {it.textCategory}) { category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu = menu)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuRowPreview() {
    JetCoffeeAppTheme {
        MenuRow(listMenu = dummyMenu)
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetCoffeeAppTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeAppTheme {
        JetCoffeeApp()
    }
}