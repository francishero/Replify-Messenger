/*
 * Copyright (C) 2017 Moez Bhatti <innovate.bhatti@gmail.com>
 *
 * This file is part of replify.
 *
 * replify is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * replify is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with replify.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.innovate.replify.feature.scheduled

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import com.innovate.replify.common.base.QkAdapter
import com.innovate.replify.common.base.QkViewHolder
import com.innovate.replify.databinding.ScheduledMessageImageListItemBinding
import com.innovate.replify.util.GlideApp
import javax.inject.Inject

class ScheduledMessageAttachmentAdapter @Inject constructor(
    private val context: Context
) : QkAdapter<Uri, ScheduledMessageImageListItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QkViewHolder<ScheduledMessageImageListItemBinding> {
        return QkViewHolder(parent, ScheduledMessageImageListItemBinding::inflate).apply {
            binding.thumbnail.clipToOutline = true
        }
    }

    override fun onBindViewHolder(holder: QkViewHolder<ScheduledMessageImageListItemBinding>, position: Int) {
        val attachment = getItem(position)

        GlideApp.with(context).load(attachment).into(holder.binding.thumbnail)
    }

}
