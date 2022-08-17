/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.cameraxbasic.fragments

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.android.example.cameraxbasic.R
import com.bumptech.glide.Glide
import java.io.File
import kotlin.math.max


/** Fragment used for each individual page showing a photo inside of [GalleryFragment] */
class PhotoFragment internal constructor() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ImageView(context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments ?: return
        val resource = args.getString(FILE_NAME_KEY)?.let { File(it) } ?: R.drawable.ic_photo
//        drawBodyKeypoints((resource as BitmapDrawable).bitmap)
        Glide.with(view).load(resource).into(view as ImageView)

        //           var holder = fragmentGalleryBinding.surfaceView.holder
        //          var canvas = holder.lockCanvas()
        //           var bitmap = fragmentGalleryBinding.surfaceView.draw()
//                canvas?.let { canvas ->  }
//
    }
    companion object {
        private const val FILE_NAME_KEY = "file_name"

        fun create(image: File) = PhotoFragment().apply {
            arguments = Bundle().apply {
                putString(FILE_NAME_KEY, image.absolutePath)
            }
        }
    }

    fun drawBodyKeypoints(input: Bitmap) {
        val paintCircle = Paint().apply {
            strokeWidth = 3F
            color = Color.RED
            style = Paint.Style.FILL
        }
        val paintLine = Paint().apply {
            strokeWidth = 1F
            color = Color.RED
            style = Paint.Style.STROKE
        }

        val paintText = Paint().apply {
            textSize = 30F //PERSON_ID_TEXT_SIZE
            color = Color.BLUE
            textAlign = Paint.Align.LEFT
        }

   //     val output = input.copy(Bitmap.Config.ARGB_8888, true)
        val originalSizeCanvas = Canvas(input)
        originalSizeCanvas.drawLine(0F, 0F, 100F, 100F, paintLine)
        originalSizeCanvas.drawCircle(50F, 50F, 50F, paintCircle )
    }

}