@import exercise.util.NamedRoutes
<form action="${NamedRoutes.loginPath()}" method="post">
    Войти
  <input type="text" placeholder="name" name="name" />
  <input type="password" placeholder="Password" name="password" />
  <input type="submit" />
</form>