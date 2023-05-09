package com.mry.jetcoffeeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mry.jetcoffeeapp.R
import com.mry.jetcoffeeapp.model.Menu
import com.mry.jetcoffeeapp.ui.theme.JetCoffeeAppTheme

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column{
            Image(
                painter = painterResource(id = menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = modifier.padding(8.dp)) {
                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                    ),
                )
                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    JetCoffeeAppTheme {
        MenuItem(
            Menu(
                image = R.drawable.menu1,
                title = "Tiramisu Coffee Milk",
                price = "Rp 28.000"
            )
        )
    }
}