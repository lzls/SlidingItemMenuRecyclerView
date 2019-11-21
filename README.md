# SlidingItemMenuRecyclerView [![](https://jitpack.io/v/freeze-frames/SlidingItemMenuRecyclerView.svg)](https://jitpack.io/#freeze-frames/SlidingItemMenuRecyclerView)

Though the styles of left sliding to open the hidden menu of RecyclerView's itemView are diverse,
the common case is that they are not elegant enough. This kind of item menu imitated from a
new feature as introduced in iOS 11 like iOS' current version of WeChat shows, may be an unusual one
as there may not have been a similar implementation on other RecyclerView libraries yet.

<div align="center">
    <img src="https://raw.githubusercontent.com/ApksHolder/SlidingItemMenuRecyclerView/master/simrv.gif" width="300">
</div>


## Usage
The layout file of RecyclerView's itemView needs just to follow the one below and everything
will work normally without any more extra code to be written in your class file.
Then set OnClickListeners for your menu items to respond to the user's interactions as needed.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <TextView
        android:id="@+id/text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingLeft="10dp"
        android:paddingTop="5dp"
        android:paddingRight="10dp"
        android:paddingBottom="5dp"
        android:drawablePadding="10dp"
        android:drawableLeft="@mipmap/ic_launcher_round"
        android:drawableStart="@mipmap/ic_launcher_round"
        android:background="@drawable/default_selector_recycler_item"
        android:textAlignment="viewStart"
        android:gravity="center_vertical|start" />

    <FrameLayout
        android:layout_width="1000dp"
        android:layout_height="match_parent">

        <!-- Put your menu items here. The first one will be shown at the horizontal start. -->

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@color/orange">

            <TextView
                android:id="@+id/button_rename"
                android:layout_width="100dp"
                android:layout_height="match_parent"
                android:text="@string/rename"
                android:textSize="16sp"
                android:textColor="@android:color/white"
                android:gravity="center" />
        </FrameLayout>

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@color/red">

            <TextView
                android:id="@+id/button_delete"
                android:layout_width="100dp"
                android:layout_height="match_parent"
                android:text="@string/delete"
                android:textSize="16sp"
                android:textColor="@android:color/white"
                android:gravity="center" />
        </FrameLayout>

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@color/skyBlue">

            <TextView
                android:id="@+id/button_top"
                android:layout_width="80dp"
                android:layout_height="match_parent"
                android:text="@string/top"
                android:textSize="16sp"
                android:textColor="@android:color/white"
                android:gravity="center" />
        </FrameLayout>
    </FrameLayout>
</LinearLayout>
```
For more usages, please download source code to see.


## Pull Requests
I will gladly accept pull requests for bug fixes and feature enhancements but please do them
in the `developers` branch.


## License
Copyright 2017-2019 刘振林

Licensed under the Apache License, Version 2.0 (the "License"); <br>
you may not use this file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing permissions and limitations
under the License.
