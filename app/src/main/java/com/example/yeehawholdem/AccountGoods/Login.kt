package com.example.yeehawholdem.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.yeehawholdem.R
import com.example.yeehawholdem.Screen

//TODO add the sign in functionality, implement a forgot password button as well as the corresponding code for that
//Probably change the image used as well


@Composable
fun LoginScreen(navController : NavController) {

    //username
    val usernameValue = remember { mutableStateOf("")}
    //password
    val passwordValue = remember { mutableStateOf("")}
    //visibility controller
    var passwordVisibility by remember { mutableStateOf(false) }

    //determine the visibility Icon
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

    //Box to store everything in
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomCenter)
    {

        //A box to put our pretty picture in
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.TopCenter)
        {
            //Image(painter = painterResource(id = R.drawable.pain), contentDescription = "Login Image")
        }

        //A column in the box corresponds to the sign in at the top of the screen
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.6f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colors.background)
                .padding(10.dp))
        {
            Text(
                text = "Sign In", style = TextStyle(
                    fontWeight = FontWeight.Bold
                ),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }


        //Add some space between the name of the screen and the content
        Spacer(modifier = Modifier.padding(20.dp))

        //Make a new column for our text fields as well as our create account button
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {

            // We wrap this text here in a surface call so that the user inpit text it white
            Surface() {
                //Username text field
                OutlinedTextField(
                    value = usernameValue.value,
                    onValueChange = { usernameValue.value = it },
                    label = { Text(text = "Username") },
                    placeholder = { Text(text = "Username") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(.8f)
                )
            }

            //Same reasoning for this surface call
            Surface() {
                //Password text field
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        })
                        {
                            Icon(painter = icon, contentDescription = "Visibility Icon")
                        }
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(.8f),
                    visualTransformation =
                    if (passwordVisibility)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation()
                )
            }
            //Add some space before the sign in button
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                             //TODO HERE
                //Sign in functionality
                //Something like check the user name and password in the database
                //If it exists, then send em back to the main menu
            },
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(50.dp))
            {
                Text(text = "Sign In", fontSize = MaterialTheme.typography.h5.fontSize)
            }

            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Create An Account", modifier = Modifier
                .clickable(onClick = {
                    navController.navigate(route = Screen.CreateAccount.route)
                }),
            color = MaterialTheme.colors.primary)

            Spacer(modifier = Modifier.padding(80.dp))
        }

    }
}



@Composable
@Preview
fun LoginScreenScreenPreview() {
    LoginScreen(navController = rememberNavController())
}