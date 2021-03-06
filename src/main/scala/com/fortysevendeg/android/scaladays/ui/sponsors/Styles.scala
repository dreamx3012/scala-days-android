/*
 * Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may
 *  not use this file except in compliance with the License. You may obtain
 *  a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.fortysevendeg.android.scaladays.ui.sponsors

import android.view.Gravity
import android.widget.{ImageView, LinearLayout}
import com.fortysevendeg.android.scaladays.R
import macroid.extras.LinearLayoutTweaks._
import macroid.extras.ResourcesExtras._
import macroid.extras.ViewTweaks._
import macroid.FullDsl._
import macroid.{ContextWrapper, Tweak}

import scala.language.postfixOps

trait AdapterStyles {

  def itemContentStyle(implicit context: ContextWrapper): Tweak[LinearLayout] =
    vMatchWidth +
      vPaddings(resGetDimensionPixelSize(R.dimen.padding_default)) +
      llGravity(Gravity.CENTER) +
      vBackground(R.drawable.background_list_default)

  def logoStyle(implicit context: ContextWrapper): Tweak[ImageView] =
    lp[LinearLayout](
      resGetDimensionPixelSize(R.dimen.width_sponsors_logo),
      resGetDimensionPixelSize(R.dimen.height_sponsors_logo))

}
