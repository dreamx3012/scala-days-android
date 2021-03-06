/*
 * Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.android.scaladays.ui.places

import android.widget.{TextView, LinearLayout}
import com.fortysevendeg.android.scaladays.R
import macroid.extras.ResourcesExtras._
import macroid.extras.TextViewTweaks._
import macroid.extras.ViewTweaks._
import macroid.extras.LinearLayoutTweaks._
import macroid.{ContextWrapper, Tweak}

trait PlacesInfoWindowStyles {

  def windowStyle(implicit context: ContextWrapper): Tweak[LinearLayout] =
    vWrapContent +
      llVertical +
      vPadding(
        resGetDimensionPixelSize(R.dimen.padding_info_window_left),
        resGetDimensionPixelSize(R.dimen.padding_info_window_top),
        resGetDimensionPixelSize(R.dimen.padding_info_window_right),
        resGetDimensionPixelSize(R.dimen.padding_info_window_bottom)) +
      vBackground(R.drawable.map_popover)

  def titleStyle(implicit context: ContextWrapper): Tweak[TextView] =
    vWrapContent +
      tvSizeResource(R.dimen.text_small) +
      tvColorResource(R.color.info_window_title) +
      vPadding(0, 0, 0, resGetDimensionPixelSize(R.dimen.padding_info_window_inner))

  def snippetStyle(implicit context: ContextWrapper): Tweak[TextView] =
    vWrapContent +
      tvSizeResource(R.dimen.text_info_window_snippet) +
      tvColorResource(R.color.info_window_snippet) +
      vPadding(0, 0, 0, resGetDimensionPixelSize(R.dimen.padding_default_extra_small))
  

}
