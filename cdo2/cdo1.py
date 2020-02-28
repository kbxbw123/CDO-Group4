import ocl
import math


def free(x):
  del x


def displayint(x):
  print(str(x))

def displaylong(x):
  print(str(x))

def displaydouble(x):
  print(str(x))

def displayboolean(x):
  print(str(x))

def displayString(x):
  print(x)


class CDO:
  cdo_instances = []
  cdo_index = dict({})

  def __init__(self):
    self.ps0 = 0.0
    self.sectors = []
    CDO.cdo_instances.append(self)
    self.PS_cache = dict({})


  def P(self, k, m) :
    result = 0.0
    result = 0
    result = StatFunc.comb(self.sectors[k -1].n, m) * (self.sectors[k -1].nocontagion(m) + ocl.sum([(self.sectors[k -1].contagion(i, m)) for i in range(1, m - 1 + 1)]))
    return result

  def PCond(self, k, m) :
    result = 0.0
    result = 0
    if m >= 1 :
      result = self.P(k, m) / (1 - (math.pow((1 - self.sectors[k -1].p), self.sectors[k -1].n)))
    else :
      if m < 1 :
        result = 0
    return result

  def maxfails(self, k, s) :
    result = 0
    result = 0
    if self.sectors[k -1].n <= (s//self.sectors[k -1].L) :
      result = self.sectors[k -1].n
    else :
      if self.sectors[k -1].n > (s//self.sectors[k -1].L) :
        result = s//self.sectors[k -1].L
    return result

  def PS(self, s) :
    if str(s) in self.PS_cache :
      return self.PS_cache[str(s)]
    result = self.PS_uncached(s)
    self.PS_cache[str(s)] = result
    return result


  def PS_uncached(self, s) :
    result = 0.0
    result = 0
    if s < 0 :
      result = 0
    else :
      if s == 0 :
        result = self.ps0
      else :
        if s > 0 :
          result = ocl.sum([(self.VS(k, s)) for k in range(1, len(self.sectors) + 1)]) / s
    return result



  def VS(self, k, s) :
    result = 0.0
    result = 0
    result = ocl.sum([((self.sectors[k -1].mu * mk * self.sectors[k -1].L * self.PCond(k, mk) * self.PS(s - mk * self.sectors[k -1].L))) for mk in range(1, self.maxfails(k, s) + 1)])
    return result

  def test1(self, s) :
    s.mu = 1 - (math.pow((1 - s.p), s.n))

  def test1outer(self) :
    for s in self.sectors :
      self.test1(s)

  def test2(self) :
    self.ps0 = math.exp(-ocl.sum([ _x.mu for _x in self.sectors]))

  def test3(self) :
    for s in range(0, 20 +1) :
      displaydouble(self.PS(s))

  def addCDO_sectors(cdo_x,sector_x) :
    cdo_x.sectors = ocl.includingSequence(cdo_x.sectors, sector_x)

  def removeCDO_sectors(cdo_x,sector_x) :
    cdo_x.sectors = ocl.excludingSequence(cdo_x.sectors, sector_x)

  def killCDO(cdo_x) :
    cdo_instances = ocl.excludingSet(cdo_instances, cdo_x)
    free(cdo_x)

class Sector:
  sector_instances = []
  sector_index = dict({})

  def __init__(self):
    self.name = ""
    self.n = 0
    self.p = 0.0
    self.q = 0.0
    self.L = 0
    self.mu = 0.0
    Sector.sector_instances.append(self)
    self.nocontagion_cache = dict({})


  def nocontagion(self, m) :
    if str(m) in self.nocontagion_cache :
      return self.nocontagion_cache[str(m)]
    result = self.nocontagion_uncached(m)
    self.nocontagion_cache[str(m)] = result
    return result


  def nocontagion_uncached(self, m) :
    result = 0.0
    result = 0
    result = (math.pow((1 - self.p), self.n - m)) * (math.pow(self.p, m)) * (math.pow((1 - self.q), m * (self.n - m)))
    return result



  def contagion(self, i, m) :
    result = 0.0
    result = 0
    result = (math.pow((1 - self.p), self.n - i)) * (math.pow(self.p, i)) * (math.pow((1 - self.q), i * (self.n - m))) * (math.pow((1 - (math.pow((1 - self.q), i))), m - i)) * StatFunc.comb(m, i)
    return result

  def killSector(sector_x) :
    sector_instances = ocl.excludingSet(sector_instances, sector_x)
    for cdo_xx in allInstances_CDO() :
      cdo_xx.sectors = ocl.excludingSequence(cdo_xx.sectors, sector_x)
    free(sector_x)

class StatFunc:
  statfunc_instances = []
  statfunc_index = dict({})

  def __init__(self):
    StatFunc.statfunc_instances.append(self)


  def comb(n,m) :
    result = 0
    result = 0
    if n - m < m :
      result = ocl.prd([(i) for i in range(m + 1, n + 1)])//ocl.prd([(j) for j in range(1, n - m + 1)])
    else :
      if n - m >= m :
        result = ocl.prd([(i) for i in range(n - m + 1, n + 1)])//ocl.prd([(j) for j in range(1, m + 1)])
    return result

  def killStatFunc(statfunc_x) :
    statfunc_instances = ocl.excludingSet(statfunc_instances, statfunc_x)
    free(statfunc_x)

class Test:
  test_instances = []
  test_index = dict({})

  def __init__(self):
    Test.test_instances.append(self)


def createCDO():
  cdo = CDO()
  return cdo

def allInstances_CDO():
  return CDO.cdo_instances


def createSector():
  sector = Sector()
  return sector

def allInstances_Sector():
  return Sector.sector_instances


def createStatFunc():
  statfunc = StatFunc()
  return statfunc

def allInstances_StatFunc():
  return StatFunc.statfunc_instances


def createTest():
  test = Test()
  return test

def allInstances_Test():
  return Test.test_instances


def test() :
  for loopvar_0 in allInstances_CDO() :
    loopvar_0.test1outer()
  for loopvar_1 in allInstances_CDO() :
    loopvar_1.test2()
  for loopvar_2 in allInstances_CDO() :
    loopvar_2.test3()





cdotest = CDO()
sector1 = Sector()
sector1.n = 2
sector1.p = 0.05
sector1.q = 0.01
sector1.L = 5
sector2 = Sector()
sector2.n = 2 
sector2.p = 0.02
sector2.q = 0.5
sector2.L = 10
cdotest.sectors = [sector1,sector2]
test()

