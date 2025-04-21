@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
    @if(page.getName() != null)
        <form action="${NamedRoutes.logoutPath()}" method="post">
        ${page.getName()}
        <input type="submit" value="Выйти"/>
        </form>
    @endif
    @if(page.getName() == null)
        Wrong
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif
    `)