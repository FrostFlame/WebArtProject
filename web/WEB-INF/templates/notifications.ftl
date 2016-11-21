<#include "base.ftl">

<#macro content>
<!-- content -->
<div class="page-heading">
    <h1>Recent notifications</h1>
</div>
<div class="media notification">
    <div class="media-left"><a href="#profile1">
        <img src="http://lorempixel.com/64/64/?1" alt="" class="media-object" width="64" height="64" ></a>
    </div>
    <div class="media-body">
        <h4>
            <a href="#profile1"><span class="">John Doe</span></a> liked your painting
        </h4>
        <p class="text-muted">Today at 18:30</p>
    </div>
    <div class="media-right"><a href="#post1"><img src="http://lorempixel.com/400/200/abstract?1" height="64" alt="" class="media-object"></a></div>
</div>

<div class="media notification">
    <div class="media-left"><a href="#profile2">
        <img src="http://lorempixel.com/64/64/?2" alt="" class="media-object" width="64" height="64" ></a>
    </div>
    <div class="media-body">
        <h4>
            <a href="#profile2"><span class="">Ivan Petrov</span></a> commented:
        </h4>
        <p class="comment">
            Vivamus tempus felis vel dui consectetur ornare. Nam interdum tincidunt elit, eu ultricies justo condimentum at. Sed pulvinar consequat sollicitudin.
        </p>
        <p class="text-muted">Yesterday at 14:43</p>
    </div>
    <div class="media-right"><a href="#post2"><img src="http://lorempixel.com/300/300/abstract?2" height="64" alt="" class="media-object"></a></div>
</div>

<div class="media notification">
    <div class="media-left"><a href="#profile3">
        <img src="http://lorempixel.com/64/64/?3" alt="" class="media-object" width="64" height="64" ></a>
    </div>
    <div class="media-body">
        <h4>
            <a href="#profile3"><span class="">Ivan Ivanov</span></a> challenged you!
        </h4>
        <p class="text-muted">Yesterday at 08:11</p>
    </div>
</div>
<!-- /content -->
</#macro>

<@display_page/>