//Program to remove the alphabets which are repeated more than one time. 
function findString(inputString) {
    var consecutiveRepeated = false;
    var str;
    for (var i = 0; i < inputString.length - 1; i++) {
        if (inputString[i] == inputString[i + 1]) {
            consecutiveRepeated = true;
            break;
        }
    }
    if (consecutiveRepeated == true) {
        str = inputString.substring(0, i);
        str += inputString.substring(i + 2, inputString.length);
        return findString(str);
    } else {
        return inputString;
    }
}

findString("eeabcddcbfgf");