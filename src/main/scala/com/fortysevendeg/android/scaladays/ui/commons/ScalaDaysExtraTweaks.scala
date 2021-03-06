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

package com.fortysevendeg.android.scaladays.ui.commons

import scala.language.postfixOps
import android.widget.{TextView, ImageView}
import com.fortysevendeg.android.scaladays.ui.components.CircularTransformation
import com.fortysevendeg.android.scaladays.utils.DateTimeUtils
import com.squareup.picasso.Picasso
import macroid.{ContextWrapper, ActivityContextWrapper, Tweak}
import org.joda.time.DateTime
import macroid.extras.ViewTweaks._
import macroid.extras.DeviceVersion._

object AsyncImageTweaks {
  type W = ImageView

  def roundedImage(url: String,
        placeHolder: Int,
        size: Int,
        error: Option[Int] = None)(implicit context: ActivityContextWrapper) = CurrentVersion match {
    case sdk if sdk >= Lollipop =>
      srcImage(url, placeHolder, error) + vCircleOutlineProvider(0)
    case _ =>
      roundedImageTweak(url, placeHolder, size, error)
  }

  private def roundedImageTweak(
      url: String,
      placeHolder: Int,
      size: Int,
      error: Option[Int] = None
      )(implicit activityContext: ActivityContextWrapper): Tweak[W] = Tweak[W](
    imageView => {
      val request = Picasso.`with`(activityContext.getOriginal)
          .load(url)
          .transform(new CircularTransformation(size))
          .placeholder(placeHolder)
      error map request.error
      request.into(imageView)
    }
  )

  def srcImage(
      url: String,
      placeHolder: Int,
      error: Option[Int] = None
      )(implicit context: ActivityContextWrapper): Tweak[W] = Tweak[W](
    imageView => {
      val request =
        Picasso.`with`(context.getOriginal)
          .load(url)
          .placeholder(placeHolder)
      error map request.error
      request.into(imageView)
    }
  )

  def srcImage(url: String)(implicit context: ActivityContextWrapper): Tweak[W] = Tweak[W](
    imageView => {
      Picasso.`with`(context.getOriginal)
          .load(url)
          .into(imageView)
    }
  )
}

object DateTimeTextViewTweaks {
  type W = TextView

  val defaultTimeZone = "UTC"

  import DateTimeUtils._

  def tvDateTimeHourMinute(dateTime: DateTime, timeZone: String = defaultTimeZone)(implicit context: ContextWrapper): Tweak[W] =
    Tweak[W](_.setText(parseTime(dateTime, timeZone)))

  def tvDateDay(dateTime: DateTime, timeZone: String = defaultTimeZone)(implicit context: ContextWrapper): Tweak[W] =
    Tweak[W](_.setText(parseDateSchedule(dateTime, timeZone)))

  def tvDateDateTime(dateTime: DateTime, timeZone: String = defaultTimeZone)(implicit context: ContextWrapper): Tweak[W] =
    Tweak[W](_.setText(parseDateScheduleTime(dateTime, timeZone)))

  def tvPrettyTime(dateTime: DateTime): Tweak[W] =
    Tweak[W](_.setText(parsePrettyTime(dateTime)))

}
