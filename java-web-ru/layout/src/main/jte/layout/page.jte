@import gg.jte.Content

@param Content header = null
@param Content content = null
@param Content footer = null

<head>
    <div class="header">
        ${header}
    </div>
</head>
<body>
    @if (content != null)
            <div class="content">
                ${content}
            </div>
        @endif
    @if (footer != null)
        <div class="footer">
            ${footer}
        </div>
    @endif
</body>
