package com.example.testfigma



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyNavigation()

        }
    }
}
@Composable
fun Detail(navController: NavHostController) {
    Column(Modifier.padding(20.dp)) {
        Button(onClick = { navController.navigate("one") }) {
            Text(text = "Back to One screen")
        }
    }

}
@Composable
fun MyNavigation(){
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "one"){
        composable("one"){ Main(navController = navController)}
        composable("two"){ Detail(navController = navController)}
    }
}
@Composable
fun Main(navController: NavHostController) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        HeadingGroup()
        MainImage()
        MyDrive()
        Headline()
        Hello()
//                Galery()
        Start(navController)
        Headline()
        MainText()

    }
}
@Composable
fun HeadingGroup() {
    Column(
        modifier = Modifier

            .fillMaxWidth()
            .padding(5.dp)
, verticalArrangement = Arrangement.Top,  horizontalAlignment= Alignment.Start

    ) {
//        BackgroundsTransparent()
        Text(
            text = "Headline Second Line",
            color = Color.Black.copy(alpha = 0.4f),
            lineHeight = 28.sp,
            style = TextStyle(
                fontSize = 22.sp,
                letterSpacing = 0.35.sp),
//            modifier = Modifier
//                .width(width = 329.dp)
//                .height(height = 28.dp)
        )
        Text(
            text = "Headline First Line",
            color = Color.Black,
            lineHeight = 28.sp,
            style = TextStyle(
                fontSize = 22.sp,
                letterSpacing = 0.35.sp),
//            modifier = Modifier
//                .width(width = 329.dp)
//                .height(height = 28.dp)
        )
        Text(
            text = "TAGLINE",
            color = Color(0xff007aff),
            lineHeight = 13.sp,
            style = TextStyle(
                fontSize = 11.sp,
                letterSpacing = 0.07.sp))
    }
}

//@Composable
//fun BackgroundsTransparent() {
//    Column(
//        modifier = Modifier
//            .width(width = 375.dp)
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.transperent),
//            contentDescription = "Background",
//            modifier = Modifier
//                .width(width = 375.dp)
//                .height(height = 96.dp))
//        DividerEmpty()
//    }
//}

@Composable
fun DividerEmpty() {
    Box(
        modifier = Modifier
            .width(width = 375.dp)
            .height(height = 1.dp))
}
@Composable
fun MainImage(){
    Image(painter = painterResource(id = R.drawable.canadaroad), contentDescription = "", modifier = Modifier
        .fillMaxWidth()
        .height(100.dp),
        contentScale = ContentScale.FillBounds
        )

}
@Composable
fun MyDrive(){
    Box(modifier = Modifier
        .padding(top = 5.dp, bottom = 5.dp)
        .fillMaxWidth(1f)
        .height(5.dp)
        .background(Color.Gray)
        )
        {

        }
}
@Composable
fun Headline(){
    Row(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Headline", fontSize = 20.sp)
        Row() {
            Text(text = "Label", fontSize = 20.sp, color = Color.Blue)
            Image(painter = painterResource(id = R.drawable.navigate), contentDescription = "", colorFilter = ColorFilter.tint(Color.Blue),
                modifier = Modifier.height(28.dp)
            )
        }

    }
}
@Composable
fun Hello(){
    Row(modifier = Modifier.padding(5.dp) ) {
        Text(text = " Hello hello hello hello hello hello hello hello hello hello hello hello hello hello hello hello hello", fontSize = 15.sp)
    }
}
//@Composable
//fun Galery(){

//    var myModifier = Modifier
//        .padding(5.dp)
//        .fillMaxWidth()
//        .background(color = Color.Gray)
//        .height(115.dp)
//    var myStyleText = TextStyle(fontSize = 20.sp, color = Color.Black)
//    LazyColumn(modifier = myModifier){
//        items(myList){
//            a -> Text(text = a, style = myStyleText)
//        }
//    }
//}
class ModelClass(var car: String,var image: Int, var model: String)
@Composable
fun Start(navController: NavHostController) {
    var myList1 = mutableListOf<ModelClass>(ModelClass("Nissan", R.drawable.aa6087c0154f1c0ad8842b0543a11246, "GTR")
        ,ModelClass("Nissan", R.drawable.aa6087c0154f1c0ad8842b0543a11246, "GTR")
    ,ModelClass("Nissan", R.drawable.aa6087c0154f1c0ad8842b0543a11246, "GTR")
    ,ModelClass("Nissan", R.drawable.aa6087c0154f1c0ad8842b0543a11246, "GTR")
    ,ModelClass("Nissan", R.drawable.aa6087c0154f1c0ad8842b0543a11246, "GTR")
    ,ModelClass("Nissan", R.drawable.aa6087c0154f1c0ad8842b0543a11246, "GTR"))
LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.padding(5.dp)){
    items(myList1){
        a -> RowItem(navController,modelClass = a)
    }
}
}
@Composable
fun RowItem(navController: NavHostController, modelClass: ModelClass){
    Column(modifier = Modifier.clickable { navController.navigate("two") }){
        Image(painter = painterResource(id = modelClass.image), contentDescription = "")
        Text(text = modelClass.car, fontSize = 25.sp)
        Text(text = modelClass.model, fontSize = 15.sp)
    }
}
@Composable
fun MainText(){

    Column(
        Modifier
            .padding(7.dp)
    ) {
        Text(text = "Контейнер Column позволяет назначить вложенным компонентам высоту в соответствии с их весом. Для указания веса применяется модификатор ColumnScope.weight. Стоит учитывать, что если контейнер Column обеспечивает вертикальную прокрутку или располагается в контейере, который предполагает вертикальную прокрутку, то веса компонентов игнорируются, поскольку общее пространство по вертикали условно бесконечно. В качестве веса в функцию weight() фактически передается доля пространства в единицах f. Так, первый элемент Box имеет вес 1f, второй - 3f, третий - 2f. Соовокупный вес всех комонентов, таким образом, будет 1f + 3f + 2f = 6f. И в итоге получится, что первый элемент получит от пространства 1f/6f часть или одну шестую. Второй элемент - 3f/6f или половину простанства, а третий - 2f/6f или одну третью пространства. Таким образом будет распределено пространство по вертикали между вложенными элементами.", fontSize = 17
            .sp)
    }
}
