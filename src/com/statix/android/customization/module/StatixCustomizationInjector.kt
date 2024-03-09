package com.statix.android.customization.module

import android.content.Context
import androidx.activity.ComponentActivity
import com.android.customization.module.ThemePickerInjector
import com.android.customization.picker.notifications.ui.viewmodel.NotificationSectionViewModel
import com.android.wallpaper.module.CustomizationSections
import com.android.wallpaper.picker.di.modules.BackgroundDispatcher
import com.android.wallpaper.picker.di.modules.MainDispatcher
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

@Singleton
open class StatixCustomizationInjector @Inject constructor(
    @MainDispatcher mainScope: CoroutineScope,
    @MainDispatcher mainDispatcher: CoroutineDispatcher,
    @BackgroundDispatcher bgDispatcher: CoroutineDispatcher,
) : ThemePickerInjector(
    mainScope,
    mainDispatcher,
    bgDispatcher,
) {

  private var customizationSections: CustomizationSections? = null

  override fun getCustomizationSections(activity: ComponentActivity): CustomizationSections {
    val wallpaperColorsRepository = getWallpaperColorsRepository()
    return customizationSections
        ?: StatixCustomizationSections(
                getColorPickerViewModelFactory(
                    context = activity,
                    wallpaperColorsRepository = wallpaperColorsRepository,
                ),
                getKeyguardQuickAffordancePickerInteractor(activity),
                getKeyguardQuickAffordancePickerViewModelFactory(activity),
                getNotificationSectionViewModelFactory(activity),
                getFlags(),
                getClockCarouselViewModelFactory(
                    getClockPickerInteractor(activity.applicationContext),
                ),
                getClockViewFactory(activity),
                getDarkModeSnapshotRestorer(activity),
                getThemedIconSnapshotRestorer(activity),
                getThemedIconInteractor(),
                getColorPickerInteractor(activity, wallpaperColorsRepository),
            )
            .also { customizationSections = it }
  }
}
