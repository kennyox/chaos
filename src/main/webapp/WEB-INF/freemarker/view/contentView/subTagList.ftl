<ul id="${tagName}-tag">
[#list tagList as tag]
[#if tag_index > 0] [/#if]
<li id="${tag.name}" rel="${tag.name}"  [#if tag.desc?exists] title="${tag.desc}"[/#if]>${tag.name}</li>
[/#list]
</ul>
