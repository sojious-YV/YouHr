package co.youverify.youhr.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.youverify.youhr.presentation.ui.theme.codeInputUnfocused
import co.youverify.youhr.presentation.ui.theme.yvColor

@Composable
fun CodeInputBox(
    modifier:Modifier=Modifier,
    codeValue1: String,
    codeValue2: String,
    codeValue3: String,
    codeValue4: String,
    onValueChanged:(String,Int)->Unit) {


    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        CodeInputField(codeValue1,1,onValueChanged)
        CodeInputField(codeValue2,2,onValueChanged)
        CodeInputField(codeValue3,3,onValueChanged)
        CodeInputField(codeValue4,4,onValueChanged)


    }

}

@Composable
fun CodeInputField(value: String, index: Int, onValueChanged: (String,Int) -> Unit) {

    var borderColor by remember { mutableStateOf(codeInputUnfocused) }


    BasicTextField(
        value = value,
        onValueChange ={
               onValueChanged(it,index)
        },
        maxLines=1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle.Default.copy(fontSize = 30.sp, textAlign = TextAlign.Center),
        modifier = Modifier
            .size(36.dp, 42.dp)
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                brush = SolidColor(borderColor),
                shape = RoundedCornerShape(12.dp)
            )

            .onFocusChanged { focusState ->
                borderColor = if (focusState.isFocused) yvColor else codeInputUnfocused
            }

    )


}

@Preview
@Composable
fun CodeInputBoxPreview(){
    Surface {
        CodeInputBox(
            codeValue1 = "1",
            codeValue2 = "2",
            codeValue3 = "3",
            codeValue4 = "4",
            onValueChanged = { _, _ ->}
        )
    }
}

data class CodeInputBoxUiState(
    val input1:String,
    val input2:String,
    val input3:String,
    val input4:String,
    ){

    var text1 by mutableStateOf(input1)
    var text2 by mutableStateOf(input2)
    var text3 by mutableStateOf(input3)
    var text4 by mutableStateOf(input4)
    val inputs= arrayOf(text1,text2,text3,text4)
}

data class CodeInputFieldState(val code:String,val borderColor:Color){
    var text by mutableStateOf(code)
    var color by mutableStateOf(code)
}