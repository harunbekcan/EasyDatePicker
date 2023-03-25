## EasyDatePicker
[![](https://jitpack.io/v/harunbekcan/EasyDatePicker.svg)](https://jitpack.io/#harunbekcan/EasyDatePicker)

![datepicker](https://user-images.githubusercontent.com/74143219/227620572-eed7bc8b-3bc9-4c59-859a-fa50fc2dfb87.png)

## Installation

Add this to project level `build.gradle`

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Add the dependency into you app level `build.gradle`

```
dependencies {
    implementation 'com.github.harunbekcan:EasyDatePicker:VersionName'
}
```
## Usage

```
private var startDate = Calendar.getInstance()
private val startDateListener = MutableLiveData<String>()
```
```
EasyDatePicker(this)
            .setDate(startDate)
            .setDatePickerStyle(R.style.StyleExample)
            .setFormatType(DATE_FORMAT)
            .setListener(startDateListener)
            .setEditText(findViewById(R.id.startDateEditText))
            .show()
```
