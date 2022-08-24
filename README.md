# Weather-App

## The trade offs you made and why

I previously divided the work into 4 parts, knowing that I wouldn't be able to do it in 3 hours, due to KTS and modules. But I preferred to take the risk and deliver a setup that is worth it.

Part 1 - Init project + buildSrc + Kotlin DSL + Gradle KTS (better dependency management) (45 min)

- new project -> fragment w/ viewModel
- new directory -> buildSrc
- buildSrc -> new empty file called `build.gradle.kts` w/ `kotlin-dsl` plugin
- convert Gradle files to kts
- add dependencies

Part 2 - Create modules (split responsibilities) + Cleanup modules (45 min)

- new module -> library -> resources 
- new module -> library -> core
- manage dependencies around the modules
- start DI 

Part 3 - Development (2h00)

- MVVM
- Finish DI
- Fetch data
- UI

Part 4 - Tests + Cleanup (30 min)

Total = 4h

## How to run your project or any special setup

Java 11 is required for Gradle plugin.

<img width="987" alt="Captura de Tela 2022-08-12 às 10 00 15" src="https://user-images.githubusercontent.com/12548332/184359003-3868ced7-34a2-40bb-8d5b-481050896568.png">


## 3rd party libraries or copied code you may have used

- Retrofit + Okhttp + Coroutines for network
- Kodein for DI
- Navigation for fragment's management
- ViewModel + StateFlow for architecture
- Glide for image
- AppCompat + Material for UI
- Mockk + Coroutines + jUnit for testing

## Any other information that you would like us to know.

If I had more time:
- Would make better coverage of unit tests
- Would put the viewmodel as data inside the xml to control the visibility of states instead of doing this in the fragment
- A better UI. I would make a horizontal list with the ConsolidatedWeather that are not part of the main day.
- Would add more information and make the days clickable for more details.
