This Smart-Dialog-View library is hosted on JitPack 

[![](https://jitpack.io/v/rajagcs08/smart-dialog-view.svg)](https://jitpack.io/#rajagcs08/smart-dialog-view)

## About :  Smart-Dialog-View
In the default alert dialog, customization can be challenging. Each time, you need to fully customize it according to your preferences. However, the smart-dialog-view library provides a fancy skinned dialog view that allows for easy customization of title, description, colors, positions, and more. This library is designed to be useful for Android developers looking to reuse existing components rather than reinvent the wheel

## Usage
If your project is older and does not follow the latest project file structure, add the repositories block to your project's **build.gradle** file. If your project follows the latest structure, add it to your **settings.gradle** file.

**For build.gradle (older project structure):**
```java
repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}
```
**For settings.gradle (latest project structure):**
```java
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
```

Add the following line to your module level **build.gradle** file
```java
implementation ("com.github.rajagcs08:smart-dialog-view:1.0.5")
```
Now, perform a Gradle sync in your project. After a successful sync, you are ready to use the Smart Dialog View in your activities or fragments. Here's an example of how you can invoke it

```java
SmartAlertDialog.Builder(supportFragmentManager,this)
    .setTitle("Successful")
    .setContent("Your Account has been created successfully..")
    .setDialogCategory(DialogCategory.SUCCESS)
    .setDialogStyle(DialogStyle.CURVED)
    .setDialogPosition(DialogPosition.BOTTOM)
    .setPositiveButton(PositiveButton("Okay"))
    .show()
```
Output will be like this

<img src="https://github.com/rajagcs08/smart-dialog-view/blob/master/images/output_success.jpg" alt="Alt Text" style="width: 256px; height: auto;"/>

## Customizable options

| **S.No**| **Options** | **Description** |
|---------|-------------|-----------------|
| 1 | setTitle | Input will be a String, and the given String will be displayed as the title of the dialog. |
| 2 | setContent | Input will be a String, and the given String will be displayed as the message of the dialog. |
| 3 | setTitleColor | Input will be a color integer, and the given color will be applied to the dialog title. |
| 4 | setContentColor |  Input will be a color integer, and the given color will be applied to the dialog message. |



