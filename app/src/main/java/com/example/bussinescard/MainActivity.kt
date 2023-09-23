package com.example.bussinescard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinescard.ui.theme.BussinesCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinesCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(
                        stringResource(R.string.Full_name), stringResource(R.string.job_title)
                    )
                    Biodata(
                        contactPerson = stringResource(R.string.contact_person),
                        socialPerson = stringResource(
                            R.string.social_media
                        ),
                        emailPerson = stringResource(R.string.emailPerson)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Image(
            painter = image,
            contentDescription = "Logo",
            modifier = modifier
                .height(100.dp)
                .width(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = message,
            fontSize = 36.sp,
            lineHeight = 50.sp,
            modifier = modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            modifier = modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun Biodata(
    contactPerson: String, socialPerson: String, emailPerson: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {
        ContacPerson(contactPerson)
        SocialPerson(socialPerson)
        EmailPerson(emailPerson)
    }
}

@Composable
fun BussinessApp() {
    Column {
        GreetingText(stringResource(R.string.Full_name), stringResource(R.string.job_title))
        Biodata(
            contactPerson = stringResource(R.string.contact_person), socialPerson = stringResource(
                R.string.social_media
            ), emailPerson = stringResource(R.string.emailPerson)
        )
    }
}

@Composable
fun SocialPerson(socialPerson: String, modifier: Modifier = Modifier) {
    val socialIcon = Icons.Rounded.MailOutline
    Row() {
        Icon(
            socialIcon, contentDescription = "email", modifier.padding(8.dp)
        )
        Text(
            text = socialPerson, modifier.padding(8.dp)
        )
    }
}

@Composable
fun ContacPerson(contactPerson: String, modifier: Modifier = Modifier) {
    val phoneIcon = Icons.Rounded.Phone
    Row() {
        Icon(
            phoneIcon, contentDescription = "phone", modifier.padding(8.dp)
        )
        Text(
            text = contactPerson, modifier = modifier.padding(8.dp)
        )

    }
}

@Composable
fun EmailPerson(emailPerson: String, modifier: Modifier = Modifier) {
    val emailIcon = Icons.Rounded.Person
    Row() {
        Icon(
            emailIcon, contentDescription = "email", modifier.padding(8.dp)
        )
        Text(
            text = emailPerson, modifier = modifier.padding(8.dp)
        )

    }
}

@Preview(showBackground = true, backgroundColor = 0xff444444)
@Composable
fun GreetingPreview() {
    BussinesCardTheme {
//        GreetingText(stringResource(R.string.Full_name), stringResource(R.string.job_title))
//        Biodata(
//            contactPerson = stringResource(R.string.contact_person),
//            socialPerson = stringResource(
//                R.string.social_media
//            )
//        )
        BussinessApp()
    }
}