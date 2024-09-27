
<form
    name="ordenadorForm"
    class="search-form"
    method="post"
    action="FiltrarOrdenadores"
    onsubmit="return validateForm()">
    
    <label for="myInput">Buscar por número de serie:</label>
    
    <div class="input-group">
        <input
            type="text"
            id="myInput"
            onkeyup="filterList()"
            name="p_numeroSerie"
            placeholder="Buscar en la lista..."
            required>
        <button
            type="submit"
            class="search-button">
            <i class="fa fa-search"></i>
        </button>
    </div>
</form>

