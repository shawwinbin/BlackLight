/* 
 * Copyright (C) 2014 Peter Cai
 *
 * This file is part of BlackLight
 *
 * BlackLight is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BlackLight is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BlackLight.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.papdt.blacklight.ui.comments;

import android.os.Bundle;

import info.papdt.blacklight.cache.comments.StatusCommentApiCache;
import info.papdt.blacklight.cache.statuses.HomeTimeLineApiCache;
import info.papdt.blacklight.ui.statuses.SingleActivity;
import info.papdt.blacklight.ui.statuses.TimeLineFragment;

public class StatusCommentFragment extends TimeLineFragment
{
	private long mId;
	
	public StatusCommentFragment() {
		init();
	}
	
	public StatusCommentFragment(long id) {
		Bundle args = new Bundle();
		args.putLong("id", id);
		setArguments(args);
		init();
	}
	
	private void init() {
		
		if (getArguments() != null) {
			mId = getArguments().getLong("id");
		} else {
			mId = 0;
		}
		mBindOrig = false;
	}

	@Override
	protected HomeTimeLineApiCache bindApiCache() {
		return new StatusCommentApiCache(getActivity(), mId);
	}

	@Override
	protected void initTitle() {
		
	}
	
	@Override
	protected void newPost() {
		((SingleActivity) getActivity()).commentOn();
	}
	
}
