### Android富文本实现图文混排  
**效果图**  

<img src="https://upload-images.jianshu.io/upload_images/1472453-1fde10e9f96fc215.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" width="300" height="500" >

像图中的效果，大家在开发并不少见，大家可能不知道android提供了实现图文混排的类。大家或许会写一个布局或者使用drawableLeft这个属性实现文本的左侧图标。

**android提供了这两个类SpannableString和SpannableStringBuilder实现图文混排**

SpannableString其实和String一样，都是一种字符串类型，SpannableString可以直接作为TextView的显示文本，不同的是SpannableString可以通过使用其方法setSpan方法实现字符串各种形式风格的显示,重要的是可以指定设置的区间，也就是为字符串指定下标区间内的子字符串设置格式。
SpannableStringBuilder应该开发的小伙伴知道StringBuilder，可以使用append()方法实现字符串拼接，非常方便。同样，SpannableString中也有SpannableStringBuilder，顾名思义，就是实现对，SpannableString的一个拼接效果，同样是append()方法，可以实现各种风格效果的SpannableString拼接，非常实用。

**SpannableStringBuilder和SpannableString主要通过使用setSpan(Object what, int start, int end, int flags)改变文本样式。 对应的参数：**
    
    start：指定Span的开始位置
    end：指定Span的结束位置，并不包括这个位置。
    flags：取值有如下四个
    Spannable.SPAN_EXCLUSIVE_INCLUSIVE：在 Span前面输入的字符不应用 Span的效果，在后面输入的字符应用Span效果。
    Spannable.SPAN_INCLUSIVE_EXCLUSIVE：在 Span前面输入的字符应用 Span 的效果，在后面输入的字符不应用Span效果。
    Spannable.SPAN_INCUJSIVE_INCLUSIVE：在 Span前后输入的字符都应用 Span 的效果。
    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前后都不包括。
    what： 对应的各种Span，不同的Span对应不同的样式。已知的可用类有：
    BackgroundColorSpan : 文本背景色
    ForegroundColorSpan : 文本颜色
    MaskFilterSpan : 修饰效果，如模糊(BlurMaskFilter)浮雕
    RasterizerSpan : 光栅效果
    StrikethroughSpan : 删除线
    SuggestionSpan : 相当于占位符
    UnderlineSpan : 下划线
    AbsoluteSizeSpan : 文本字体（绝对大小）
    DynamicDrawableSpan : 设置图片，基于文本基线或底部对齐。
    ImageSpan : 图片
    RelativeSizeSpan : 相对大小（文本字体）
    ScaleXSpan : 基于x轴缩放
    StyleSpan : 字体样式：粗体、斜体等
    SubscriptSpan : 下标（数学公式会用到）
    SuperscriptSpan : 上标（数学公式会用到）
    TextAppearanceSpan : 文本外貌（包括字体、大小、样式和颜色）
    TypefaceSpan : 文本字体
    URLSpan : 文本超链接
    ClickableSpan : 点击事件


**License**  

    Copyright 2018 StevenYan88
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0  
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
