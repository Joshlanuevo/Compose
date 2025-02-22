package com.vancoding.userlist.ui.screens.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.vancoding.userlist.ui.common.LoadState
import com.vancoding.userlist.viewmodel.UserListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    userId: Int,
    navigateBack: () -> Unit,
    userListViewModel: UserListViewModel,
) {
    val userListState by userListViewModel.userList.collectAsState()
    val user = (userListState as? LoadState.Success)?.data?.find { it.id == userId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 56.dp), // Compensate for the navigation icon width
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "User Info",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF4F4F4)),
        ) {
            if (user != null) {
                // First Card - Avatar and Nickname
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                .aspectRatio(1f),
                            contentAlignment = Alignment.Center,
                        ) {
                            AsyncImage(
                                model = user.avatarUrl,
                                contentDescription = "User avatar",
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        Text(
                            text = user.firstName,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(top = 8.dp),
                        )
                    }
                }

                // Second Card - User Info
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                    ) {
                        // Name Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(start = 20.dp, end = 20.dp), // Add padding to both sides
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Full Name:",
                                fontSize = 14.sp,
                                color = Color(0xFF9C9C9C),
                                modifier = Modifier.width(100.dp), // Fixed width for the label
                            )

                            Text(
                                text = "${user.firstName} ${user.lastName}",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 16.dp), // Add some spacing between label and value
                            )
                        }

                        // Divider
                        HorizontalDivider(
                            modifier = Modifier
                                .padding(horizontal = 22.dp),
                            color = Color(0xFFE0E0E0),
                        )

                        // Email Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(start = 20.dp, end = 20.dp), // Add padding to both sides
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Email:",
                                fontSize = 14.sp,
                                color = Color(0xFF9C9C9C),
                                modifier = Modifier.width(100.dp), // Fixed width for the label
                            )

                            Text(
                                text = user.email,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 16.dp), // Add some spacing between label and value
                            )
                        }
                    }
                }
            } else {
                // Loading state
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}