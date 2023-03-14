package com.statix.android.customization.module;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.android.customization.picker.quickaffordance.domain.interactor.KeyguardQuickAffordancePickerInteractor;
import com.android.customization.picker.quickaffordance.ui.viewmodel.KeyguardQuickAffordancePickerViewModel;
import com.android.wallpaper.model.CustomizationSectionController;
import com.android.wallpaper.model.CustomizationSectionController.CustomizationSectionNavigationController;
import com.android.wallpaper.model.PermissionRequester;
import com.android.wallpaper.model.WallpaperColorsViewModel;
import com.android.wallpaper.model.WallpaperPreviewNavigator;
import com.android.wallpaper.model.WallpaperSectionController;
import com.android.wallpaper.model.WorkspaceViewModel;
import com.android.wallpaper.module.CurrentWallpaperInfoFactory;
import com.android.wallpaper.module.CustomizationSections;
import com.android.wallpaper.picker.customization.ui.section.ScreenPreviewSectionController;
import com.android.wallpaper.util.DisplayUtils;

import com.statix.android.customization.model.font.FontManager;
import com.statix.android.customization.model.font.FontSectionController;
import com.statix.android.customization.model.iconpack.IconPackManager;
import com.statix.android.customization.model.iconpack.IconPackSectionController;

import java.util.ArrayList;
import java.util.List;

/** {@link CustomizationSections} for the customization picker. */
public final class StatixCustomizationSections extends DefaultCustomizationSections {

    public StatixCustomizationSections(
            KeyguardQuickAffordancePickerInteractor keyguardQuickAffordancePickerInteractor,
            KeyguardQuickAffordancePickerViewModel.Factory
                    keyguardQuickAffordancePickerViewModelFactory) {
        super(keyguardQuickAffordancePickerInteractor, keyguardQuickAffordancePickerViewModelFactory);
    }

    @Override
    public List<CustomizationSectionController<?>> getSectionControllersForScreen(
            Screen screen,
            FragmentActivity activity,
            LifecycleOwner lifecycleOwner,
            WallpaperColorsViewModel wallpaperColorsViewModel,
            WorkspaceViewModel workspaceViewModel,
            PermissionRequester permissionRequester,
            WallpaperPreviewNavigator wallpaperPreviewNavigator,
            CustomizationSectionNavigationController sectionNavigationController,
            @Nullable Bundle savedInstanceState,
            CurrentWallpaperInfoFactory wallpaperInfoFactory,
            DisplayUtils displayUtils) {
        List<CustomizationSectionController<?>> sectionControllers =
                super.getSectionControllersForScreen(screen, activity, lifecycleOwner, wallpaperColorsViewModel, workspaceViewModel,
                permissionRequester, wallpaperPreviewNavigator, sectionNavigationController, savedInstanceState, wallpaperInfoFactory,
                displayUtils);

        // Icon pack selection section.
        sectionControllers.add(new IconPackSectionController(
                IconPackManager.getInstance(activity, new OverlayManagerCompat(activity)), sectionNavigationController));

        // Font selection section.
        sectionControllers.add(new FontSectionController(
                FontManager.getInstance(activity, new OverlayManagerCompat(activity)), sectionNavigationController));

        return sectionControllers;
    }

    @Override
    public List<CustomizationSectionController<?>> getAllSectionControllers(
            FragmentActivity activity,
            LifecycleOwner lifecycleOwner,
            WallpaperColorsViewModel wallpaperColorsViewModel,
            WorkspaceViewModel workspaceViewModel,
            PermissionRequester permissionRequester,
            WallpaperPreviewNavigator wallpaperPreviewNavigator,
            CustomizationSectionNavigationController sectionNavigationController,
            @Nullable Bundle savedInstanceState,
            DisplayUtils displayUtils) {
        List<CustomizationSectionController<?>> sectionControllers =
                super.getAllSectionControllers(activity, lifecycleOwner, wallpaperColorsViewModel, workspaceViewModel, permissionRequester,
                wallpaperPreviewNavigator, sectionNavigationController, savedInstanceState, wallpaperInfoFactory, displayUtils);

        // Icon pack selection section.
        sectionControllers.add(new IconPackSectionController(
                IconPackManager.getInstance(activity, new OverlayManagerCompat(activity)), sectionNavigationController));

        // Font selection section.
        sectionControllers.add(new FontSectionController(
                FontManager.getInstance(activity, new OverlayManagerCompat(activity)), sectionNavigationController));

        return sectionControllers;
    }
}
