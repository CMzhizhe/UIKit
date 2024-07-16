# UIKit
自定义控件库
在app的build.gradle中添加
```

	 
```

- 自定中间拐角平滑度
- 自定义凹陷值
- 自定义阴影深度

### 说明

(修改自)[https://github.com/ZYF99/UIKit]

在布局文件中直接使用
```
    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab_add"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="30dp"
        android:backgroundTint="#ffffff"
        android:elevation="6dp"
        android:src="@android:drawable/ic_input_add"
        android:tint="#000000"
        app:borderWidth="0dp"
        app:fabSize="normal"
        app:layout_constraintBottom_toBottomOf="@+id/bottomnavigation"
        app:layout_constraintEnd_toEndOf="@+id/bottomnavigation"
        app:layout_constraintStart_toStartOf="@+id/bottomnavigation"
        app:rippleColor="#00FFFFFF"/>

    <com.zhangyf.gapbottomnavigationview.GapBottomNavigationView
        android:id="@+id/bottomnavigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:backgroundTint="#ffffff"
        android:clickable="false"
        android:padding="8dp"
        app:center_radius="32dp"
        app:corner_radius="12dp"
        app:elevation="5dp"
        app:itemBackground="@null"
        app:itemIconTint="#000000"
        app:itemTextColor="#000000"
        app:labelVisibilityMode="labeled"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:menu="@menu/navigation"
        app:shadow_length="4dp"
        tools:targetApi="lollipop" />
```
  - app:center_radius： 用来指定凹陷的半径
  - shadow_length：用来指定高度（阴影大小）
  - cornerRadius：用来指定拐角处的平滑半径大小
	



	

 
