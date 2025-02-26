@import exercise.dto.users.MainPage
@param MainPage page

@template.layout.page(
    header = @`
            <p>
                <a href="/">Main page</a>
            </p>
            </p>
                <a href="/users">Users</a>
            </p>
        `,
    footer = @`
        <p>
            <a href="https://github.com/maximkoo/hexlet-assignments">This is Github link</a>
        </p>
    `
)