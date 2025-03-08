@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>Все поцты</h1>

                <table class="table table-striped">
                    @for(var post : page.getPosts())
                        <tr>
                            <td>
                                ${post.getId()}
                            </td>
                            <td>
                                <a href="/posts/${post.getId()}">${post.getName()}</a>
                            </td>
                            <td>
                                ${post.getBody()}
                            </td>
                        </tr>
                    @endfor
                </table>
            </main>
        </div>
        <div>
        <p>
        <a href="/posts/?page=${page.getPageNum()-1}">Назад</a>
        <a href="/posts/?page=${page.getPageNum()+1}">Вперед</a>
        </p>
        </div>
    `
)