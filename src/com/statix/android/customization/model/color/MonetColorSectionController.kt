/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.statix.android.customization.model.color

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.annotation.Nullable

import com.statix.android.customization.picker.color.MonetColorFragment
import com.statix.android.customization.picker.color.MonetColorSectionView

import com.android.wallpaper.R
import com.android.wallpaper.model.CustomizationSectionController
import com.android.wallpaper.model.CustomizationSectionController.CustomizationSectionNavigationController
import com.android.wallpaper.util.LaunchUtils

import java.util.List

/** A {@link CustomizationSectionController} for system icons. */

public class MonetColorSectionController(private val sectionNavigationController: CustomizationSectionNavigationController)
        : CustomizationSectionController<MonetColorSectionView> {

    private val TAG = "MonetColorSectionController"

    override fun isAvailable(context: Context?) : Boolean {
        return ColorUtils.isMonetEnabled(context!!)
    }

    override fun createView(context: Context?) : MonetColorSectionView {
        val monetColorSectionView = LayoutInflater.from(context!!).inflate(R.layout.monet_section_view, /* root= */ null) as MonetColorSectionView

        monetColorSectionView.setOnClickListener({v -> sectionNavigationController.navigateTo(
                MonetColorFragment.newInstance(context.getString(R.string.monet_color_section_title)))})

        return monetColorSectionView
    }

    companion object {
        private val TAG = "MonetColorSectionController"
    }

}
